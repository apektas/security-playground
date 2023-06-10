 -- table creations are done via hibernate

INSERT INTO public.customers (customer_id, name,email,mobile_number, pwd, role,create_dt)
VALUES (nextval('customers_customer_id_seq') ,'Abdurrahman','apektas@example.com','111', '$2y$12$oRRbkNfwuR8ug4MlzH5FOeui.//1mkd.RsOAJMbykTSupVy.x/vb2', 'admin',current_timestamp);


INSERT INTO accounts (customer_id, account_number, account_type, branch_address, create_dt)
VALUES (1, 1865764534, 'Savings', '123 Main Street, New York', current_date);

-- select * from gen_random_uuid();

-- select  now()::DATE - 1;

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
                                  closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, now()::DATE - 1, 'Coffee Shop', 'Withdrawal', 30,34500,now()::DATE -7);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
                                  closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, now()::DATE-6, 'Uber', 'Withdrawal', 100,34400,now()::DATE -6);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
                                  closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, now()::DATE -5, 'Self Deposit', 'Deposit', 500,34900,now()::DATE -5);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
                                  closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, now()::DATE -4, 'Ebay', 'Withdrawal', 600,34300,now()::DATE -4);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
                                  closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, now()::DATE -2, 'OnlineTransfer', 'Deposit', 700,35000,now()::DATE -2);

INSERT INTO account_transactions (transaction_id, account_number, customer_id, transaction_dt, transaction_summary, transaction_type,transaction_amt,
                                  closing_balance, create_dt)  VALUES (gen_random_uuid(), 1865764534, 1, now()::DATE -1, 'Amazon.com', 'Withdrawal', 100,34900,now()::DATE -1);
