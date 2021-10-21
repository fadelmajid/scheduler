CREATE TABLE event (
    id SERIAL PRIMARY KEY,
    name TEXT NOT NULL,
    event_date DATE NOT NULL,
    created_date DATE DEFAULT CURRENT_DATE,
    updated_date DATE
)