import axiosLib from "axios";

const axios = axiosLib.create({
  baseURL: "http://localhost:8080",
  timeout: 1000,
});

export default axios;
