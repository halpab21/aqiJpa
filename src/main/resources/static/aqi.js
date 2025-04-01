const url = "http://localhost:8080";


const getAqi = async () => {
    const response = await fetch(`${url}/getAll`);
    const data = await response.json();
    return data.map(p => parseFloat(p.value));
};

const getAqiLabels = async () => {
    const response = await fetch(`${url}/getAll`);
    const data = await response.json();
    return data.map(p => p.year);
};

const getAqiDataLabels = async () => {
    const response = await fetch(`${url}/getAll`);
    const data = await response.json();
    return data.map(p => p.aqiString);
};