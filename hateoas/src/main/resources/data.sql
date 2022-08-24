insert into students (id, age, is_deleted, name) values (1, "21", 0, "Pesho");
insert into students (id, age, is_deleted, name) values (2, "22", 0, "Gosho");
insert into students (id, age, is_deleted, name) values (3, "20", 1, "Anna");

insert into courses (id, name, price) values (1, "Spring", 100);
insert into courses (id, name, price) values (2, "JS", 50);

insert into orders (id, course_id, student_id) values (1, 1, 1);
insert into orders (id, course_id, student_id) values (2, 1, 2);
insert into orders (id, course_id, student_id) values (3, 2, 2);