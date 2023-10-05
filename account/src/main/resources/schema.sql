CREATE TABLE IF NOT EXISTS account (
                                       account_id INT AUTO_INCREMENT PRIMARY KEY,
                                       account_number VARCHAR(6) NOT NULL,
                                       account_type VARCHAR(15) NOT NULL,
                                       initial_balance DECIMAL(10,2) NOT NULL,
                                       status BOOLEAN DEFAULT false,
                                       client_id INT NOT NULL
);

CREATE TABLE IF NOT EXISTS move (
                                    move_id INT AUTO_INCREMENT PRIMARY KEY,
                                    move_date DATETIME NOT NULL,
                                    move_type VARCHAR(200) NOT NULL,
                                    amount DECIMAL(10,2) NOT NULL,
                                    description VARCHAR(200) NOT NULL,
                                    account_id INT NOT NULL,
                                    FOREIGN KEY (account_id) REFERENCES account(account_id)
);
