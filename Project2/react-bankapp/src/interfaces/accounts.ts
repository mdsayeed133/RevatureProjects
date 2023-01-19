export interface AccountType {
  accountTypeId: number;
  accountTypeName: string;
}

export interface Account {
  accountId: number;
  user: {
    userId: number;
    username: string;
    password: string;
    firstName: string;
    lastName: string;
    address: string;
    email: string;
  };
  amount: number;
  accountType: {
    accountTypeId: number;
    accountTypeName: string;
  };
}