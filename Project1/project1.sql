
/*
 * Creating the tables
 */

CREATE TABLE ERS_USER_ROLES (
    role_id serial primary key,
    user_role TEXT not null
);

CREATE TABLE ERS_REIMBURSEMENT_TYPE (
    type_id serial primary key,
    reimb_type TEXT not null
);

CREATE TABLE ERS_REIMBURSEMENT_STATUS (
    status_id serial primary key,
    reimb_status TEXT not null 
);


CREATE TABLE ERS_USERS (
    ers_username text primary key,
    ers_password text not null,
    user_first_name text ,
    user_last_name text ,
    ers_user_roles_id_fk INT not null,
    foreign key (ers_user_roles_id_fk) references ERS_USER_ROLES(role_id)
);

CREATE TABLE ERS_REIMBURSEMENT (
    reimb_id serial primary key,
    reimb_username_fk text not null,
    reimb_amount numeric(10,2) not null,
    reimb_description text not null,
    ers_reimbursement_type_id_fk INT ,
    ers_reimbursement_status_id_fk INT not null,
    foreign key (reimb_username_fk) references ERS_USERS(ers_username),
    foreign key (ers_reimbursement_type_id_fk) references ERS_REIMBURSEMENT_TYPE(type_id),
    foreign key (ers_reimbursement_status_id_fk) references ERS_REIMBURSEMENT_STATUS(status_id)
);
/*
 * -----------------------------------------------------------------
*/

/*
 * drop tables
*/
	drop table ers_reimbursement cascade;
	drop table ers_users cascade;
/*
 * -----------------------------------------------------------------
*/

/*
 *insert into tables
*/
	
	insert into ERS_USER_ROLES(user_role) values ('Employee');
	insert into ers_reimbursement_type(reimb_type) values('Flight');
	insert into ers_reimbursement_type(reimb_type) values('Meal');
	insert into ers_reimbursement_status (reimb_status) values('pending');
	insert into ers_reimbursement_status (reimb_status) values('approve');
	insert into ers_reimbursement_status (reimb_status) values('deny');
	insert into	ers_users(ers_username, ers_password,user_first_name ,user_last_name,ers_user_roles_id_fk) values ('mdsayeed133','mdsayeed133','mohammed','islam','1' );
	insert into ERS_REIMBURSEMENT(reimb_username_fk,reimb_amount,reimb_description,ers_reimbursement_type_id_fk,ers_reimbursement_status_id_fk) values ('mdsayeed133','50.50','Flight form dallas to los angels', '1','1');
/*
 * -----------------------------------------------------------------
*/

/*
 *select for tables
*/
	select * from ers_user_roles;
	select * from ers_reimbursement_type;
	select * from ers_reimbursement_status;
	select * from ers_users;
	select * from ers_reimbursement;
	
/
 * -----------------------------------------------------------------
*/




