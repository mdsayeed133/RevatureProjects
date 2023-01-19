import React, { useState } from 'react';
import axios from 'axios';

interface Props {
    accountId: number;
    accountAmount: number;
    setAmount: (amount: number) => void;
}

const SendMoney: React.FC<Props> = ({ accountId, accountAmount, setAmount }) => {
    const [toAccountId, setToAccountId] = useState<number>(0);
    const [amount, setSentAmount] = useState<number>(0);

    const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
        event.preventDefault();
        try {
            const response = await axios.post('http://localhost:5555/bank/transfer', {
                fromAccountId: accountId,
                toAccountId: toAccountId,
                amount: amount,
            });
            if (response.status === 200) {
                setAmount(accountAmount - amount);
            }
        } catch (error) {
            console.error(error);
        }
    };

    return (
        <form onSubmit={handleSubmit}>
            <label>
                To Account ID:
                <input
                    type="number"
                    value={toAccountId}
                    onChange={event => setToAccountId(parseFloat(event.target.value))}
                    required
                />
            </label>
            <br />
            <label>
                Amount:
                <input
                    type="number"
                    value={amount}
                    onChange={event => setSentAmount(parseFloat(event.target.value))}
                    required
                />
            </label>
            <br />
            <button type="submit">Send</button>
        </form>
    );
};

export default SendMoney;