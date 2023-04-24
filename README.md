# Wakefulness Time API

An API for estimating wakefulness time by caffeine content of the different types of Coffee.

## Usage

Let's take a look at what an example test case would look like using `wakefulness-time-api`.

#### GET:
```
http://localhost:8080/api/wakefulness?coffee=COFFEE&robusta=ROBUSTA&time=TIME
```

#### Parameters:

- coffee: Type of Coffee.
- robusta: Proportion of Robusta in percentage (Default = 0).
- time: Enter the time manually or let it go (Default = now).

## Response

```json
{
  "id": 1,
  "status": "OK",
  "time": "07:30",
  "coffee": "Americano",
  "arabica": "100%",
  "robusta": "0%",
  "caffeine": "249 mg",
  "wakefulness": "10-13 hours",
  "min": "17:45",
  "max": "20:15",
  "avg": "18:40"
}
```