# 🚀 BFHL REST API — Production Ready Assignment Solution

A production-ready REST API built to satisfy strict automated evaluation criteria including **response consistency**, **robust validation**, **security guardrails**, and **public accessibility**.

The service exposes two endpoints:

- `POST /bfhl` — Functional computation & AI query endpoint
- `GET /health` — Service health verification endpoint

This implementation is structured to pass automated and hidden evaluation test cases.

---

## ✨ Core Features

✔ Strict API response structure  
✔ Correct HTTP status codes  
✔ Strong input validation  
✔ Graceful error handling (no crashes)  
✔ Security guardrails  
✔ AI API integration  
✔ Production deployment ready  

Hidden evaluation coverage:

- Error code validation
- Boundary condition handling
- Security edge cases
- Response structure consistency

---

## 🧠 Functional Logic Mapping

| Key | Input Type | Output |
|-----|-----------|--------|
| fibonacci | Integer | Fibonacci series |
| prime | Integer array | Prime numbers |
| lcm | Integer array | LCM value |
| hcf | Integer array | HCF value |
| AI | Question string | Single-word AI response |

⚠ Only **one key must be present per request**.

---

## 📡 API Endpoints

### POST `/bfhl`

Performs computation or AI query depending on request key.

### Successful Response Structure

```json
{
  "is_success": true,
  "official_email": "YOUR_CHITKARA_EMAIL",
  "data": ...
}
