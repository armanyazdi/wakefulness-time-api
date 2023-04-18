# Wakefulness Time API

An API for estimating wakefulness time by caffeine content of the drinks (e.g. Coffee, Tea and Energy Drinks).

## Usage

Let's take a look at what an example test case would look like using `wakefulness-time-api`.

**GET:**
```
http://localhost:8080/api/wakefulness?drink=DRINK&time=TIME
```

- drink: Caffeinated drink.
- time: Enter the time manually or let it go (defaultValue = "now").

## Response

```json
{
  "id": 1,
  "status": "OK",
  "time": "07:30",
  "drink": "Americano",
  "caffeine": "249 mg",
  "wakefulness": "10-14 hrs",
  "min": "17:45",
  "max": "21:15",
  "avg": "19:40"
}
```
