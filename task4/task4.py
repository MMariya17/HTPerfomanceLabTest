import sys

def min_moves_to_equal_elements(nums, max_moves=20):

    if not nums:
        return 0

    min_num = min(nums)
    max_num = max(nums)

    min_moves = float('inf')
    best_target = min_num

    for target in range(min_num, max_num + 1):
        moves = sum(abs(num - target) for num in nums)
        if moves < min_moves:
            min_moves = moves
            best_target = target

    return min_moves


def main():
    if len(sys.argv) != 2:
        print("Использование: python task4.py numbers.txt")
        return

    input_file = sys.argv[1]

    try:
        with open(input_file, 'r') as f:
            nums = [int(line.strip()) for line in f if line.strip()]

        if not nums:
            print("Файл пуст")
            return

        print(f"Прочитаны числа: {nums}")

        # Вычисляем минимальное количество ходов
        result = min_moves_to_equal_elements(nums)

        print(f"Минимальное количество ходов: {result}")

        # Проверяем ограничение в 20 ходов
        if result <= 20:
            print(result)
        else:
            print("Невозможно привести к одному числу за 20 ходов")

    except FileNotFoundError:
        print(f"Ошибка: файл {input_file} не найден")
    except ValueError:
        print("Ошибка: файл содержит некорректные данные")
    except Exception as e:
        print(f"Ошибка: {e}")


if __name__ == "__main__":
    main()