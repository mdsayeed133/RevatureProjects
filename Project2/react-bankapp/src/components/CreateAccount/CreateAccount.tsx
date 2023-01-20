import React, { useState } from 'react';
import axios from 'axios';

interface Props {
    userId: number;
}

const CreateAccount: React.FC<Props> = ({ userId }) => {
    const [amount, setAmount] = useState<number>(0);
    const [accountTypeId, setAccountTypeId] = useState<number>(1);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:5555/bank/accounts', {
                userId: userId,
                amount: amount,
                accountTypeId: accountTypeId
            });
            if (response.status === 201) {
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
            <label>
                Account Type:
                <select value={accountTypeId} onChange={event => setAccountTypeId(parseFloat(event.target.value))}>
                    <option value={1}>Checking</option>
                    <option value={2}>Savings</option>
                </select>
            </label>
            <br />
            <button type="submit">Create Account</button>
        </form>
    );
};

export default CreateAccount;

