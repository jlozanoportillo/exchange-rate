CREATE TABLE IF NOT EXISTS exchange_rate
(
   id INT PRIMARY KEY AUTO_INCREMENT,
   source_currency VARCHAR (3) NOT NULL,
   target_currency VARCHAR (3) NOT NULL,
   rate DOUBLE NOT NULL
);

CREATE INDEX idx_exchange_rate_currency_pair ON exchange_rate (source_currency, target_currency);