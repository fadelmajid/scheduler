CREATE TABLE event (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    eventDate DATE NOT NULL,
    createdDate DATE DEFAULT CURRENT_DATE,
    updatedDate DATE
)