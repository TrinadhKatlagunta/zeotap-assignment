import axios from 'axios';

const API_BASE_URL = 'http://localhost:8080/api/ingest'; // update if different

export const sendIngestionRequest = (formData) => {
  return axios.post(API_BASE_URL, formData, {
    headers: {
      'Content-Type': 'multipart/form-data',
    },
  });
};
