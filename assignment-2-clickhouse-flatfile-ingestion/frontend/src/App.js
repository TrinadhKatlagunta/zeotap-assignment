import React, { useState } from 'react';

const App = () => {
  const [source, setSource] = useState('');
  const [host, setHost] = useState('');
  const [port, setPort] = useState('');
  const [columns, setColumns] = useState([]);
  const [selectedColumns, setSelectedColumns] = useState([]);

  const handleColumnChange = (e) => {
    const value = Array.from(e.target.selectedOptions, option => option.value);
    setSelectedColumns(value);
  };

  const handleSubmit = () => {
    console.log("Data source:", source);
    console.log("Columns selected:", selectedColumns);
    console.log("Host:", host);
    console.log("Port:", port);
  };

  return (
    <div>
      <h1>ClickHouse ↔ Flat File Ingestion Tool</h1>
      <form onSubmit={handleSubmit}>
        <div>
          <label>Source:</label>
          <select value={source} onChange={(e) => setSource(e.target.value)}>
            <option value="ClickHouse">ClickHouse</option>
            <option value="Flat File">Flat File</option>
          </select>
        </div>
        <div>
          <label>Host:</label>
          <input type="text" value={host} onChange={(e) => setHost(e.target.value)} />
        </div>
        <div>
          <label>Port:</label>
          <input type="number" value={port} onChange={(e) => setPort(e.target.value)} />
        </div>
        <div>
          <label>Columns:</label>
          <select multiple={true} value={selectedColumns} onChange={handleColumnChange}>
            {columns.map((col, index) => (
              <option key={index} value={col}>{col}</option>
            ))}
          </select>
        </div>
        <button type="submit">Submit</button>
      </form>
    </div>
  );
}

export default App;
