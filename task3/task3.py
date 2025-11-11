import json
import sys

def load_json_file(filename):

    with open(filename, 'r', encoding='utf-8') as f:
        return json.load(f)


def save_json_file(data, filename):

    with open(filename, 'w', encoding='utf-8') as f:
        json.dump(data, f, indent=2, ensure_ascii=False)


def fill_test_values(tests_structure, values_dict):

    for test in tests_structure:
        test_id = test.get('id')

        if test_id in values_dict:
            test['value'] = values_dict[test_id]

        if 'values' in test:
            fill_test_values(test['values'], values_dict)

    return tests_structure


def main():
    if len(sys.argv) != 4:
        print("Использование: python task3.py values.json tests.json report.json")
        return

    values_file = sys.argv[1]
    tests_file = sys.argv[2]
    report_file = sys.argv[3]

    try:
        values_data = load_json_file(values_file)
        tests_data = load_json_file(tests_file)

        values_dict = {item['id']: item['value'] for item in values_data['values']}

        report_data = fill_test_values(tests_data['tests'], values_dict)

        result = {'tests': report_data}
        save_json_file(result, report_file)

        print(f"Отчет успешно сохранен в файл: {report_file}")

    except FileNotFoundError as e:
        print(f"Ошибка: файл не найден - {e}")
    except json.JSONDecodeError as e:
        print(f"Ошибка: неверный формат JSON - {e}")
    except Exception as e:
        print(f"Ошибка: {e}")


if __name__ == "__main__":
    main()