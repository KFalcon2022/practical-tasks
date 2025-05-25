package com.walking.lesson170_reflection.task2;

import java.lang.reflect.Constructor;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Реализуйте метод, который принимает параметром список классов и возвращает
 * <code>Map{@literal <}Class{@literal <}?>, Object></code>. При этом:
 *
 * <ol>
 * <li> Каждый из передаваемых в метод классов должен иметь один публичный конструктор.
 *      Наличие параметров опционально;</li>
 * <li> Любой класс <code>A</code> может принимать одним из параметров объект класса <code>B</code> только при условии,
 *      что <code>B</code> также указан в списке передаваемых в метод классов;</li>
 * <li> Если возникает любого рода циклическая зависимость: конструктор <code>A</code> принимает параметром
 *      объект <code>B</code>, а конструктор <code>B</code> принимает параметром объект <code>A</code> -
 *      должно быть выброшено исключение. Актуально также и для неявных циклических зависимостей
 *      (<code>A</code> для создания требует объект <code>B</code>, <code>B</code> - требует <code>C</code>,
 *      <code>C</code> требует <code>A</code>) любой глубины;</li>
 * <li> Параметром конструктора могут быть переданы только объекты, которые будут состоять в составе возвращаемого
 *    объекта <code>Map</code>. Таким образом любой объект определенного класса (из входящего списка) должен быть
 *    создан единожды, независимо от того, сколько раз он будет передаваться как параметр конструктора в объекты
 *    других классов из списка.</li>
 * </ol>
 */
public class Main {
    public static void main(String[] args) {
        createObjects(List.of(A.class, B.class, C.class, D.class, E.class));
        createObjects(List.of(A.class, B.class, F.class, G.class));
    }

    public static Map<Class<?>, Object> createObjects(List<Class<?>> classes) {
        var objects = new HashMap<Class<?>, Object>();

        for (var clazz : classes) {
            getInstance(clazz, objects, new HashSet<>());
        }

        return objects;
    }

    /**
     * Метод получения или создания объекта для конкретного класса. При необходимости также создает объекты
     * для параметров конструктора целевого класса.
     *
     * @param triggeredBy Служит для защиты от циклических зависимостей. Содержит в себе информацию о классах,
     *                    создание объектов которых привело к вызову метода для данного объекта <code>class</code>.
     */
    private static Object getInstance(Class<?> clazz, Map<Class<?>, Object> objects, Set<Class<?>> triggeredBy) {
        var foundObject = objects.get(clazz);

        if (foundObject != null) {
            return foundObject;
        }

        // Убеждаемся, что создание объекта не было вызвано рекурсивно предыдущей попыткой создать объект того же типа
        if (triggeredBy.contains(clazz)) {
            throw new RuntimeException("Circular dependency is not allowed");
        }

        // Актуализируем triggeredBy для следующих рекурсивных вызовов
        triggeredBy.add(clazz);

        var constructor = getTargetConstructor(clazz);
        var parameters = getConstructorParameters(constructor, objects, triggeredBy);

        return objects.compute(clazz, (k, value) -> getClassInstanceNoEx(constructor, parameters));
    }

    private static Constructor<?> getTargetConstructor(Class<?> clazz) {
        var constructors = clazz.getDeclaredConstructors();

        if (constructors.length != 1) {
            throw new RuntimeException("Expected exactly one constructor");
        }

        return constructors[0];
    }

    private static List<?> getConstructorParameters(Constructor<?> constructor, Map<Class<?>, Object> objects,
                                                    Set<Class<?>> triggeredBy) {
        if (constructor.getParameters().length == 0) {
            return List.of();
        }

        return Arrays.stream(constructor.getParameterTypes())
                .map(paramClass -> getInstance(paramClass, objects, triggeredBy))
                .toList();
    }

    private static Object getClassInstanceNoEx(Constructor<?> constructor, List<?> params) {
        try {
            constructor.setAccessible(true);
            return constructor.newInstance(params.toArray());
        } catch (Exception e) {
            var declaringClassName = constructor.getDeclaringClass()
                    .getName();

            throw new RuntimeException("Unable to create instance of %s".formatted(declaringClassName), e);
        }
    }
}

// Чтобы не плодить множество отдельных тестовых классов - они объявлены в этом же файле.
// В реальных задачах подобный подход недопустим
class A {

}

class B {

}

class C {
    private final B b;

    public C(B b) {
        this.b = b;
    }
}

class D {
    private final A a;
    private final C c;

    public D(A a, C c) {
        this.a = a;
        this.c = c;
    }
}

class E {
    private final A a;
    private final B b;
    private final D d;

    public E(A a, B b, D d) {
        this.a = a;
        this.b = b;
        this.d = d;
    }
}

// Тестовые классы для проверки на циклическую зависимость
class F {
    private final A a;
    private final B b;
    private final G g;

    public F(A a, B b, G g) {
        this.a = a;
        this.b = b;
        this.g = g;
    }
}

class G {
    private final A a;
    private final F f;

    public G(A a, F f) {
        this.a = a;
        this.f = f;
    }
}
