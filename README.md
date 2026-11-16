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
- A terminal or IDE with UTF-8 support

## Run it

For this project, the safest option is to use the regular Windows Command Prompt (`cmd`) instead of PowerShell, because PowerShell can preserve a different default encoding behavior. Run the following commands:

```bat
chcp 65001
javac -encoding UTF-8 KerbolOrbiter.java
java -Dfile.encoding=UTF-8 -cp . KerbolOrbiter
```

This ensures both the terminal and Java use UTF-8, which prevents emoji characters from appearing as garbled text.

If you are using VS Code, open a regular terminal such as Command Prompt or Windows Terminal with a UTF-8 profile, then run the same commands above. The `-encoding UTF-8` and `-Dfile.encoding=UTF-8` flags are important for correct emoji output.

### VS Code setup

You can configure VS Code to run the project in a CMD-style terminal by creating the following files in a `.vscode` folder inside the project:

`tasks.json`

```json
{
  "version": "2.0.0",
  "tasks": [
    {
      "label": "Compile Kerbol Orbiter",
      "type": "shell",
      "command": "cmd",
      "args": [
        "/c",
        "chcp 65001 && javac -encoding UTF-8 KerbolOrbiter.java"
      ],
      "options": {
        "cwd": "${workspaceFolder}"
      },
      "problemMatcher": []
    },
    {
      "label": "Run Kerbol Orbiter",
      "type": "shell",
      "command": "cmd",
      "args": [
        "/c",
        "chcp 65001 && java -Dfile.encoding=UTF-8 -cp . KerbolOrbiter"
      ],
      "options": {
        "cwd": "${workspaceFolder}"
      },
      "problemMatcher": []
    }
  ]
}
```

`launch.json`

```json
{
  "version": "0.2.0",
  "configurations": [
    {
      "name": "Run Kerbol Orbiter (CMD)",
      "type": "node-terminal",
      "request": "launch",
      "command": "cmd /c \"chcp 65001 && java -Dfile.encoding=UTF-8 -cp . KerbolOrbiter\"",
      "cwd": "${workspaceFolder}",
      "console": "integratedTerminal"
    }
  ]
}
```

Then open Run and Debug in VS Code and select `Run Kerbol Orbiter (CMD)`, or run the task from the Terminal menu.

## Run the naming tests

This project currently uses a small Java test program, so you do not need to install a test framework. In Command Prompt, run:

```bat
javac -encoding UTF-8 KerbolOrbiter.java tests\PlanetNameTest.java
java -Dfile.encoding=UTF-8 -cp .;tests PlanetNameTest
```

The test source is in the `tests` folder but intentionally has no `package` declaration. `Planet` is currently in Java's default package, and Java does not allow classes in a named package to import classes from the default package. The tests check that a planet gets its name and ID when first named, and that renaming it updates its existing registry entry without creating a duplicate. If all checks pass, you will see `All Planet naming tests passed.` You can also run the `Test Planet Naming` task from VS Code's Terminal → Run Task menu.

## Notes

This project is intentionally simple and educational. It is a good starting point for experimenting with Java class design, nested classes, and basic simulation data.

If you want to extend it, possible ideas include:

- adding more planets and moons
- calculating orbital velocity and period
- printing a full system summary
- storing objects in a list or database
