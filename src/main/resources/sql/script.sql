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


select current_timestamp - INTERVAL '30' DAY;

 create table public.notice_details
 (
     notice_id      serial
         primary key,
     create_dt      timestamp(6) with time zone,
     notice_beg_dt  timestamp(6) with time zone,
     notice_details varchar(255),
     notice_end_dt  timestamp(6) with time zone,
     notice_summary varchar(255),
     update_dt      timestamp(6) with time zone
 );

 alter table public.notice_details
     owner to db_user;




 INSERT INTO notice_details ( notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
 VALUES ('Home Loan Interest rates reduced', 'Home loan interest rates are reduced as per the goverment guidelines. The updated rates will be effective immediately',
         current_timestamp - INTERVAL '30' DAY, current_timestamp + INTERVAL '30' DAY, current_timestamp, null);

 INSERT INTO notice_details ( notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
 VALUES ('Net Banking Offers', 'Customers who will opt for Internet banking while opening a saving account will get a $50 amazon voucher',
         current_timestamp - INTERVAL '30' DAY, current_timestamp + INTERVAL '30' DAY, current_timestamp, null);

 INSERT INTO notice_details ( notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
 VALUES ('Mobile App Downtime', 'The mobile application of the EazyBank will be down from 2AM-5AM on 12/05/2020 due to maintenance activities',
         current_timestamp - INTERVAL '30' DAY, current_timestamp + INTERVAL '30' DAY, current_timestamp, null);

 INSERT INTO notice_details ( notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
 VALUES ('E Auction notice', 'There will be a e-auction on 12/08/2020 on the Bank website for all the stubborn arrears.Interested parties can participate in the e-auction',
         current_timestamp - INTERVAL '30' DAY, current_timestamp + INTERVAL '30' DAY, current_timestamp, null);

 INSERT INTO notice_details ( notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
 VALUES ('Launch of Millennia Cards', 'Millennia Credit Cards are launched for the premium customers of EazyBank. With these cards, you will get 5% cashback for each purchase',
         current_timestamp - INTERVAL '30' DAY, current_timestamp + INTERVAL '30' DAY, current_timestamp, null);

 INSERT INTO notice_details ( notice_summary, notice_details, notice_beg_dt, notice_end_dt, create_dt, update_dt)
 VALUES ('COVID-19 Insurance', 'EazyBank launched an insurance policy which will cover COVID-19 expenses. Please reach out to the branch for more details',
         current_timestamp - INTERVAL '30' DAY, current_timestamp + INTERVAL '30' DAY, current_timestamp, null);



 INSERT INTO authorities (customer_id, name) VALUES (1, 'VIEWACCOUNT');

 INSERT INTO authorities (customer_id, name) VALUES (1, 'VIEWCARDS');

 INSERT INTO authorities (customer_id, name)  VALUES (1, 'VIEWLOANS');

 INSERT INTO authorities (customer_id, name) VALUES (1, 'VIEWBALANCE');

-- delete  from authorities;

 INSERT INTO authorities (customer_id, name) VALUES (1, 'ROLE_USER');

 INSERT INTO authorities (customer_id, name) VALUES (1, 'ROLE_ADMIN');



 INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('4565XXXX4656', 1, 'Credit', 10000, 500, 9500, current_timestamp);

 INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('3455XXXX8673', 1, 'Credit', 7500, 600, 6900, current_timestamp);

 INSERT INTO cards (card_number, customer_id, card_type, total_limit, amount_used, available_amount, create_dt)
 VALUES ('2359XXXX9346', 1, 'Credit', 20000, 4000, 16000, current_timestamp);

