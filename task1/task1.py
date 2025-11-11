import sys

def circular_path(n, m):
    if n <= 0 or m <= 0:
        return ""

    path = []
    current = 1

    while True:
        path.append(current)
        current = (current + m - 1) % n
        if current == 0:
            current = n
        if current == 1:
            break

    return "".join(map(str, path))


def main():
    if len(sys.argv) != 5:
        print("Использование: python task1.py n1 m1 n2 m2")
        return

    try:
        n1, m1, n2, m2 = map(int, sys.argv[1:5])

        # Вычисляем пути для обоих массивов
        path1 = circular_path(n1, m1)
        path2 = circular_path(n2, m2)

        # Объединяем результаты
        result = path1 + path2
        print(result)

    except ValueError:
        print("Ошибка: все аргументы должны быть целыми числами")


if __name__ == "__main__":
    main()