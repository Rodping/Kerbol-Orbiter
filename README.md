# Kerbol Orbiter

A small Java learning project inspired by Kerbal Space Program. The goal is to model a simple planetary system and experiment with Java classes, object-oriented design, and basic orbital/physical values.

> Disclaimer: this is an early alpha project created for learning and experimentation. It is not a polished or production-ready game or simulation.

## What is included

- A `Planet` class for creating solar-system objects
- Planet attributes such as name, type, radius, and mass
- Orbital metadata such as apoapsis, periapsis, and semi-major axis
- A simple example setup for planets like `Kerbin` and `Mun`

## Project structure

- `KerbolOrbiter.java` – main entry point and example system setup
- `Planet` – the planet model, embedded in `KerbolOrbiter.java` for this version
- `PlanetNameTest.java` – small test program for planet naming and renaming

## Prerequisites

- Java JDK 8 or newer
- Gradle 8.14.3
- A terminal or IDE with UTF-8 support

## Run it

On Windows, open Command Prompt (`cmd`) in the project folder and run:

```bat
chcp 65001
javac -encoding UTF-8 KerbolOrbiter.java
java -Dfile.encoding=UTF-8 -cp . KerbolOrbiter
```

These commands compile the source using UTF-8 and run it with UTF-8 output, so the emoji display correctly. You can also build and run the application with Gradle:

```sh
gradle build
gradle run
```

## Run the naming tests

The custom naming test program runs as part of the Gradle `check` and `build` tasks:

```sh
gradle check
```

The test source intentionally has no `package` declaration because `Planet` is in Java's default package. The tests check that a planet gets its name and ID when first named, and that renaming it updates its existing registry entry without creating a duplicate. If all checks pass, you will see `All Planet naming tests passed.`

## Notes

This project is intentionally simple and educational. It is a good starting point for experimenting with Java class design, nested classes, and basic simulation data.

If you want to extend it, possible ideas include:

- adding more planets and moons
- calculating orbital velocity and period
- printing a full system summary
- storing objects in a list or database
