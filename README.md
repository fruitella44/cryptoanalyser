# Cryptoanalyser
# Шифр "Цезаря"

1 - При запуске приложения пользователю предоставляется 4 варианта действий:
Encode, Decode, Bruteforce, Exit

2 - После выбора нужной функции, запрашивается имя файла. По умолчанию прописаны: inputText.txt, outputText.txt
* Если необходимо прописать свой путь, в классе Write задать путь с помощью библиотеки NIO. Пример:
> Paths.get("yourFileName")

3 - Логика работы алгоритмов:
* Считывание текста построчно
* Сдвиг всех символов по ключу выбранного от пользователя
* Добавление каждого символа в StringBuilder
* Запись в файл

4 - Класс BruteForce содержит в себе массив "100 самых популярных слов на русском языке".
Во время расшифровки брутфорса идет допустимо возможный перебор ключей на длину алфавита. 
- Если расшифрованное слово сопадает со словом из коллекции, то условие выполняется, текст считается расшифрованным и перебор ключей останавливается.

* Программа работает только с русским текстом, кодировка UTF-8.
* Программа работает с текстовым файлом, расширение ".txt".
* Логи пишутся в директорию "applicationLogs"
* Проект собран на jdk-11, jar файл лежит в корневом каталоге проекта
* Команда для запуска: 
> java -jar CryptoAnalyzer.jar
