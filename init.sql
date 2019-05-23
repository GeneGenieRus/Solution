USE test;

DROP TABLE IF EXISTS part;

CREATE TABLE part(
	id INT(11) NOT NULL AUTO_INCREMENT,
	name     VARCHAR(50) NOT NULL,
	amount INT(11)      NOT NULL,
	need BOOLEAN NOT NULL,
	PRIMARY KEY (id))
	

    ENGINE = InnoDB
    DEFAULT CHARACTER SET = utf8;

insert into part(name, amount, need)
values ('Жесткий диск', 2, true),
('Оптический привод', 5, false),
('Floppy-дисковод', 0, false),
 ('Блок питания', 10, true),
 ('Центральный процессор', 12, true),
 ('Wifi-адаптер', 7, false),
 ('Bluetooth-адаптер', 5, false),
 ('Ethernet-адаптер', 2, false),
 ('Корпус системного блока', 10, true),
 ('Подсветка корпуса', 12, false),
 ('Модуль оперативной памяти', 7, true),
 ('Звуковая карта', 5, false),
 ('Видеокарта', 2, true),
 ('Кулер', 30, true),
 ('Радиатор охлаждения', 7, true),
 ('Шлейф HDD-sata', 5, true),
 ('Speaker', 2, false),
 ('Плата видеозахвата', 3, false),
 ('Твердотельный накопитель', 3, false),
 ('PCI-USB контроллер', 3, false),
 ('PCI-COM/LPT контроллер', 3, false);
