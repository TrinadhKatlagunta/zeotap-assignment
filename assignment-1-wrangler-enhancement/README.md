# Assignment 1: Enhance Wrangler with Byte Size and Time Duration Parsers

This part of the project focuses on enhancing the CDAP Wrangler library to add support for BYTE_SIZE and TIME_DURATION types.

---

## ✅ Features Implemented

- 🔧 Grammar Updated: `Directives.g4` includes `BYTE_SIZE`, `TIME_DURATION` tokens.
- ⚙️ New Classes:
  - `ByteSize.java` and `TimeDuration.java` (with parsing & unit conversion logic).
- 🧠 Parser Integration:
  - Modified visitor logic and token handler in Wrangler core.
- 🧮 New Directive:
  - `AggregateStatsDirective.java` that performs aggregation on byte size and time columns.
- ✅ Unit Tests:
  - `ByteSizeTest.java`, `TimeDurationTest.java`, `AggregateStatsDirectiveTest.java`
- 📝 Usage documentation and example recipes added in this README.
- 🤖 AI prompts used in `prompts.txt`

---

## 🧪 Example Usage Recipe

```text
aggregate-stats :data_transfer_size :response_time total_size_mb total_time_sec
