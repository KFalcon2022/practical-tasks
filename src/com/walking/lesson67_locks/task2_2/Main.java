package com.walking.lesson67_locks.task2_2;

import com.walking.lesson67_locks.task2_1.model.Accident;
import com.walking.lesson67_locks.task2_1.model.AccidentIdentificator;
import com.walking.lesson67_locks.task2_1.service.AccidentService;

import java.time.LocalDate;

/**
 * Реализуйте систему диспетчерской для аварийной службы.
 * <p>
 * В диспетчерскую могут поступать сообщения об авариях из разных источников (разных потоков),
 * в т.ч. различные сведения об одной и той же аварии.
 * Требуется обрабатывать и сохранять (в коллекцию) данную информацию.
 * Рекомендую делать привязку к уникальному идентификатору аварии и дате информации.
 * Удаление информации о случившихся авариях не предусмотрено.
 * <p>
 * Также требуется предоставлять информацию об авариях сотрудникам диспетчерской по запросам.
 * Одному сотруднику соответствует один поток выполнения.
 * Возможна ситуация, когда сотрудник запрашивает информацию сразу о нескольких авариях.
 * <p>
 * Частота запросов информации сотрудниками находится в паритете с частотой обновления информации из источников.
 */
public class Main {
    public static void main(String[] args) {
        AccidentService accidentService = new AccidentService();

        Thread accidentAddingThread = new Thread(getAccidentAddTask(accidentService));
        Thread accidentGettingThread = new Thread(getAccidentGettingTask(accidentService));

        accidentAddingThread.start();
        accidentGettingThread.start();
        accidentService.add(new Accident("Accident 0", new AccidentIdentificator(0, LocalDate.of(2024, 03, 03))));

    }

    private static Runnable getAccidentAddTask(AccidentService accidentService) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                accidentService.add(new Accident(
                        "Accident " + i,
                        new AccidentIdentificator(i * 31, LocalDate.now())));
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }

    private static Runnable getAccidentGettingTask(AccidentService accidentService) {
        return () -> {
            for (int i = 0; i < 100; i++) {
                accidentService.get(new Accident(
                        "",
                        new AccidentIdentificator(
                                (i + 1) * 31,
                                LocalDate.of(2024, 03, 03))));
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
    }
}