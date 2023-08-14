CREATE TABLE todo (
    id SERIAL PRIMARY KEY,
    content VARCHAR(255),
    creation_time DATE,
    due_date DATE,
    completed BOOLEAN,
    important BOOLEAN
);
