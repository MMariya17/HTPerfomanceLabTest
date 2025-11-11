import sys

def check_point_relative_to_ellipse(center_x, center_y, radius_x, radius_y, point_x, point_y):

    normalized_x = point_x - center_x
    normalized_y = point_y - center_y

    ellipse_value = (normalized_x / radius_x) ** 2 + (normalized_y / radius_y) ** 2

    if abs(ellipse_value - 1.0) < 1e-10:
        return 0
    elif ellipse_value < 1.0:
        return 1
    else:
        return 2


def main():
    if len(sys.argv) != 3:
        print("Использование: python task2.py ellipse.txt points.txt")
        return

    ellipse_file = sys.argv[1]
    points_file = sys.argv[2]

    try:
        with open(ellipse_file, 'r') as f:
            lines = f.readlines()
            center_line = lines[0].strip().split()
            radius_line = lines[1].strip().split()

            center_x = float(center_line[0])
            center_y = float(center_line[1])
            radius_x = float(radius_line[0])
            radius_y = float(radius_line[1])

        with open(points_file, 'r') as f:
            points = []
            for line in f:
                coords = line.strip().split()
                if len(coords) == 2:
                    points.append((float(coords[0]), float(coords[1])))

        for point_x, point_y in points:
            result = check_point_relative_to_ellipse(center_x, center_y, radius_x, radius_y, point_x, point_y)
            print(result)

    except FileNotFoundError as e:
        print(f"Ошибка: файл не найден - {e.filename}")
    except ValueError as e:
        print(f"Ошибка: неверный формат данных в файле")
    except Exception as e:
        print(f"Ошибка: {e}")


if __name__ == "__main__":
    main()