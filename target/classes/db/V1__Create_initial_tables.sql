CREATE TABLE skill (
                       id text PRIMARY KEY,
                       name text NOT NULL
);

CREATE TABLE personnel (
                           id text PRIMARY KEY,
                           name text NOT NULL,
                           grade text NOT NULL,
                           available BOOLEAN NOT NULL
);

CREATE TABLE personnel_skill (
                                 personnel_id text NOT NULL,
                                 skill_id text NOT NULL,
                                 PRIMARY KEY (personnel_id, skill_id),
                                 CONSTRAINT fk_personnel FOREIGN KEY (personnel_id) REFERENCES personnel (id) ON DELETE CASCADE,
                                 CONSTRAINT fk_skill FOREIGN KEY (skill_id) REFERENCES skill (id) ON DELETE CASCADE
);

CREATE TABLE vacation_day (
                              id text PRIMARY KEY,
                              date text NOT NULL,
                              personnel_id text NOT NULL,
                              CONSTRAINT fk_personnel_vacation FOREIGN KEY (personnel_id) REFERENCES personnel (id) ON DELETE CASCADE
);

CREATE TABLE task (
                      id text PRIMARY KEY,
                      name text NOT NULL,
                      location text NOT NULL,
                      start_date text NOT NULL,
                      end_date text NOT NULL,
                      meals_provided BOOLEAN NOT NULL,
                      accommodation_provided BOOLEAN NOT NULL,
                      meals_details text,
                      accommodation_details text
);

CREATE TABLE task_requirement (
                                  id text PRIMARY KEY,
                                  task_id text NOT NULL,
                                  skill_id text,
                                  skill_name text,
                                  count INTEGER NOT NULL,
                                  priority text NOT NULL,
                                  CONSTRAINT fk_task_requirement_task FOREIGN KEY (task_id) REFERENCES task (id) ON DELETE CASCADE,
                                  CONSTRAINT chk_priority CHECK (priority IN ('must-have', 'should-have'))
);

CREATE TABLE assignment (
                            id text PRIMARY KEY,
                            task_id text NOT NULL,
                            personnel_id text NOT NULL,
                            status text NOT NULL,
                            requirement_id text,
                            CONSTRAINT fk_assignment_task FOREIGN KEY (task_id) REFERENCES task (id) ON DELETE CASCADE,
                            CONSTRAINT fk_assignment_personnel FOREIGN KEY (personnel_id) REFERENCES personnel (id) ON DELETE CASCADE,
                            CONSTRAINT fk_assignment_requirement FOREIGN KEY (requirement_id) REFERENCES task_requirement (id) ON DELETE SET NULL,
                            CONSTRAINT chk_status CHECK (status IN ('draft', 'final'))
);
