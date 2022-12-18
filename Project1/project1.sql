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

CREATE TABLE ERS_REIMBURSEMENT (
    reimb_id serial primary key,
    reimb_username_fk text not null,
    reimb_amount numeric(10,2) not null,
    reimb_description text not null,
    ers_reimbursement_type_id_fk INT not null,
    ers_reimbursement_status_id_fk INT not null,
    foreign key (reimb_username_fk) references ERS_USERS(ers_username),
    foreign key (ers_reimbursement_type_id_fk) references ERS_REIMBURSEMENT_TYPE(type_id),
    foreign key (ers_reimbursement_status_id_fk) references ERS_REIMBURSEMENT_STATUS(status_id)
);

CREATE TABLE ERS_USERS (
    ers_username text primary key,
    ers_password text not null,
    user_first_name text not null,
    user_last_name text not null,
    ers_user_roles_id_fk INT not null,
    foreign key (ers_user_roles_id_fk) references ERS_USER_ROLES(role_id)
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
