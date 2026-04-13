# Weather Department Information Management System (Java)

A working Java console project for managing:
- Weather stations
- Observations
- Alerts

## Project Structure

- `src/com/spos/weatherims/Main.java` – console menu and application entry point
- `src/com/spos/weatherims/WeatherDepartmentIMS.java` – business logic/service layer
- `src/com/spos/weatherims/Station.java` – station model
- `src/com/spos/weatherims/Observation.java` – observation model
- `src/com/spos/weatherims/Alert.java` – alert model

## Compile

```bash
javac -d out src/com/spos/weatherims/*.java
```

## Run

```bash
java -cp out com.spos.weatherims.Main
```

## Features

1. Add station
2. List stations
3. Add weather observation
4. Show latest observation by station
5. Issue alert
6. List alerts

The app starts with two sample stations and observations for quick testing.


## One-command Run

```bash
./run.sh
```

## Sample Non-interactive Demo

```bash
printf '2\n6\n0\n' | ./run.sh
```
