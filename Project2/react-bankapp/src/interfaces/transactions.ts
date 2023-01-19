export interface Transaction {
  transactionId: number;
  account: {
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
  };
  amount: number;
  description: string;
  type: {
    transactionTypeId: number;
    transactionTypesName: string;
  };
}

