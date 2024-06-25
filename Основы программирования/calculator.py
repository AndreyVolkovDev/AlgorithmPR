import re
import math
import os

# Файл для сохранения истории
HISTORY_FILE = 'calculator_history.txt'

def evaluate_expression(expression):
    # Функция для вычисления выражения с использованием eval
    try:
        # Замена символа '|' на функцию abs
        expression = re.sub(r'\|(.+?)\|', r'abs(\1)', expression)
        # Замена '^' на '**' для возведения в степень
        expression = expression.replace('^', '**')
        # Вычисление выражения
        result = eval(expression)
        return result
    except Exception as e:
        return str(e)

def save_to_history(expression, result):
    # Функция для сохранения уравнения и результата в файл
    with open(HISTORY_FILE, 'a') as f:
        f.write(f'{expression} = {result}\n')

def print_history():
    # Функция для вывода истории уравнений
    if os.path.exists(HISTORY_FILE):
        with open(HISTORY_FILE, 'r') as f:
            print(f.read())
    else:
        print("История пуста.")

def main():
    while True:
        print("Введите уравнение (или 'exit' для выхода, 'history' для просмотра истории):")
        user_input = input().strip()

        if user_input.lower() == 'exit':
            break
        elif user_input.lower() == 'history':
            print_history()
        else:
            result = evaluate_expression(user_input)
            print(f"Результат: {result}")
            save_to_history(user_input, result)

if __name__ == '__main__':
    main()
