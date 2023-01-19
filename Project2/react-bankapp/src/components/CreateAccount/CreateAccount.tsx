import React, { useState } from 'react';
import axios from 'axios';

import '../CreateAccount/CreateAccount.css'
interface Props {
    userId: number;
}

const CreateAccount: React.FC<Props> = ({ userId }) => {
    const [amount, setAmount] = useState<number>(0);
    const [accountTypeId, setAccountTypeId] = useState<number>(0);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:5555/bank/accounts', {
                userId: userId,
                amount: amount,
                accountTypeId: accountTypeId
            });
            if (response.status === 200) {
                console.log('Account created successfully');
            }
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                Amount:
                <input
                    type="number"
                    value={amount}
                    onChange={event => setAmount(parseFloat(event.target.value))}
                    required
                />
            </label>
            <br />
            <button type="submit" onClick={() => setAccountTypeId(1)}>Checking</button>
            <button type="submit" onClick={() => setAccountTypeId(2)}>Savings</button>
        </form>
    );
};

export default CreateAccount;
