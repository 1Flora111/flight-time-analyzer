 Flight Time Tracker

Групаа: ИС-О-22/1
Задание: 1 задание
Автор: Кирилл Семенов 
Программа: Flight Time Tracker  
Язык: Java SE  

1) Описание

Данная программа рассчитывает налёт летного состава на основе данных о рейсах.  
На выходе формируется отчёт в формате `JSON`, где указано:

- Суммарное полётное время каждого специалиста за каждый месяц.
- Проверка на переработки: (Превышение 8 часов в день, превышение 36 часов в неделю, превышение 80 часов в месяц)

---------

2) Входные данные

Файл `flights.csv` должен содержать:

- Список летных специалистов (ID, имя)
- Список рейсов: (Номер рейса, тип и номер самолета; время вылета и посадки; аэропорт вылета и назначения; список участников экипажа)

---------

3) Выходной файл

После запуска программа создает `output.json`, в котором:

- Для каждого пилота указано количество налётанных часов по месяцам
- Добавлены пометки при нарушениях рабочих норм

---------
