# Используем официальный образ OpenJDK для сборки
FROM openjdk:21

# Указываем рабочую директорию внутри контейнера
WORKDIR /

# Копируем файл jar из локальной сборки в контейнер
COPY controller/target/controller-0.0.1-SNAPSHOT.jar app.jar

# Указываем команду запуска приложения
ENTRYPOINT ["java", "-jar", "app.jar"]

# Указываем порт, который будет слушать приложение
EXPOSE 8080
