import http from 'k6/http';
import { check, sleep } from 'k6';

export const options = {
    // vus: 10,
    // duration: '30s',
    vus: 5,
    duration: '10s',
    thresholds: {
        'http_req_duration': ['p(95)<800'],
        'http_req_failed': ['rate<0.01'],
        'checks': ['rate==1.0'],
    },
};

export default function () {
    const url = 'http://localhost:8080/login';
    const payload = JSON.stringify({
        user: 'admin',
        pass: 'admin123',
    });
    const params = {
        headers: {
            'Content-Type': 'application/json',
        },
    };
    const res = http.post(url, payload, params);
    check(res, {
        'status is 200': (r) => r.status === 200,
        'response is Bienvenido admin': (r) => r.body.includes('Bienvenido admin'),
    });
    sleep(1);
}