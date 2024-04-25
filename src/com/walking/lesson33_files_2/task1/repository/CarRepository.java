package com.walking.lesson33_files_2.task1.repository;

import com.walking.lesson33_files_2.task1.model.Car;
import com.walking.lesson33_files_2.task1.service.CarParser;

import java.io.*;

public class CarRepository {
    public static final String CAR_SEPARATOR = "\n";
    public static final String CAR_FIELD_SEPARATOR = " ";

    private final File source;
    private final CarReader carReader;
    private final CarWriter carWriter;

    private Car[] cars;

    public CarRepository(File source) {
        if (source == null) {
            throw new NullPointerException("Need not null File value");
        }

        this.source = source;

        this.carReader = new CarReader() {
            @Override
            public String read(File source) {
                return CarReader.super.read(source);
            }
        };

        this.carWriter = new CarWriter() {
            @Override
            public void write(File destination, Car[] cars) {
                CarWriter.super.write(destination, cars);
            }
        };

        cars = load();
    }

    /* статический фабричный метод для создания репозиториев с разными способами чтения\записи */
    public static CarRepository getOfIoType(File source, InputType input, OutputType output) {
        if (source == null) {
            throw new NullPointerException("Need not null File value");
        }
        if (input == null) {
            input = InputType.BUFFERED_READER;
        }
        if (output == null) {
            output = OutputType.BUFFERED_WRITER;
        }

        return new CarRepository(source, input.getCarReader(), output.getCarWriter());
    }

    private CarRepository(File source, CarReader carReader, CarWriter carWriter) {
        this.source = source;
        this.carReader = carReader;
        this.carWriter = carWriter;

        cars = load();
    }

    public Car[] getCars() {
        return cars;
    }

    /* не смог придумать как ограничить доступ только для CarService */
    public void setCars(Car[] cars) {
        this.cars = cars;
    }

    public void save() {
        carWriter.write(source, cars);
    }

    public Car[] load() {
        String carCandidates = carReader.read(source);

        CarParser parser = new CarParser(carCandidates);

        return parser.parseAllCars();
    }

    public enum InputType {
        FILE_READER(new CarReader() {
            @Override
            public String read(File source) {
                try (FileReader reader = new FileReader(source)) {
                    int currentChar;
                    StringBuilder carCandidates = new StringBuilder();

                    while ((currentChar = reader.read()) != -1) {
                        carCandidates.append((char) currentChar);
                    }

                    return carCandidates.toString();
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("file not found: %s ".formatted(source), e);
                } catch (IOException e) {
                    throw new RuntimeException("io exception, e");
                }
            }
        }), BUFFERED_INPUT_STREAM(new CarReader() {
            @Override
            public String read(File source) {
                try (BufferedInputStream reader = new BufferedInputStream(new FileInputStream(source))) {
                    return new String(reader.readAllBytes());
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("file not found: %s ".formatted(source), e);
                } catch (IOException e) {
                    throw new RuntimeException("io exception, e");
                }
            }
        }), BUFFERED_READER(new CarReader() {
            @Override
            public String read(File source) {
                return CarReader.super.read(source);
            }
        });

        private final CarReader carReader;

        InputType(CarReader carReader) {
            this.carReader = carReader;
        }

        private CarReader getCarReader() {
            return carReader;
        }
    }

    public enum OutputType {
        FILE_WRITER(new CarWriter() {
            @Override
            public void write(File destination, Car[] cars) {
                try (FileWriter writer = new FileWriter(destination)) {
                    for (Car car : cars) {
                        writer.write(getRepositoryView(car));
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("file not found: %s ".formatted(destination.getPath()), e);
                } catch (IOException e) {
                    throw new RuntimeException("io exception", e);
                }
            }
        }), BUFFERED_OUTPUT_STREAM(new CarWriter() {
            @Override
            public void write(File destination, Car[] cars) {
                try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(destination))) {
                    byte[] bytes;

                    for (Car car : cars) {
                        bytes = getRepositoryView(car).getBytes();

                        writer.write(bytes);
                    }
                } catch (FileNotFoundException e) {
                    throw new RuntimeException("file not found: %s ".formatted(destination.getPath()), e);
                } catch (IOException e) {
                    throw new RuntimeException("io exception", e);
                }
            }
        }), BUFFERED_WRITER(new CarWriter() {
            @Override
            public void write(File destination, Car[] cars) {
                CarWriter.super.write(destination, cars);
            }
        });

        private final CarWriter carWriter;

        OutputType(CarWriter carWriter) {
            this.carWriter = carWriter;
        }

        private CarWriter getCarWriter() {
            return carWriter;
        }
    }
}

