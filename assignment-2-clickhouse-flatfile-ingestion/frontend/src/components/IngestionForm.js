import React, { useState } from 'react';
import { sendIngestionRequest } from '../services/api';

const IngestionForm = () => {
  const [sourceType, setSourceType] = useState('');
  const [targetTable, setTargetTable] = useState('');
  const [file, setFile] = useState(null);
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!sourceType || !targetTable || !file) {
      setMessage('Please fill all fields and select a file.');
      return;
    }

    const formData = new FormData();
    formData.append('sourceType', sourceType);
    formData.append('targetTable', targetTable);
    formData.append('file', file);

    try {
      const res = await sendIngestionRequest(formData);
      setMessage(`Success: ${res.data}`);
    } catch (err) {
      console.error(err);
      setMessage('Error occurred while sending request.');
    }
  };

  return (
    <div>
      <h2>Data Ingestion Form</h2>
      <form onSubmit={handleSubmit}>
        <label>
          Source Type:
          <input
            type="text"
            value={sourceType}
            onChange={(e) => setSourceType(e.target.value)}
          />
        </label>
        <br />
        <label>
          Target Table:
          <input
            type="text"
            value={targetTable}
            onChange={(e) => setTargetTable(e.target.value)}
          />
        </label>
        <br />
        <label>
          Upload File:
          <input
            type="file"
            onChange={(e) => setFile(e.target.files[0])}
          />
        </label>
        <br />
        <button type="submit">Submit</button>
      </form>
      <p>{message}</p>
    </div>
  );
};

export default IngestionForm;
