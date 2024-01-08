import { useState } from 'react';

interface InputProps {
    label: string;
    value: string | number;
    updateValue(value: unknown): void;
}

const Input = ({ label, value, updateValue }: InputProps) => {
    return (
        <>
            <label>{label}</label>
            <input
                type="text"
                value={value}
                onChange={(el) => updateValue(el.target.value)}
            />
        </>
    );
};

export function CreateModal() {
    const [title, setTitle] = useState('');
    const [price, setPrice] = useState(0);
    const [image, setImage] = useState('');

    return (
        <div className="modal-overlay">
            <div className="modal-body">
                <h2> Cadastre um novo item no cardápio</h2>
                <form action="" className="input-container">
                    <Input label="title" value={title} updateValue={setTitle} />
                    <Input label="price" value={price} updateValue={setPrice} />
                    <Input label="image" value={image} updateValue={setImage} />
                </form>
            </div>
        </div>
    );
}
