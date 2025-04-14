import numpy as np
def input_matrix(n, m, name):
    print(f"Enter elements of Matrix {name} row-wise:")
    matrix = []
    for i in range(n):
        row = list(map(float, input(f"Row {i+1}: ").split()))
        if len(row) != m:
            print("Invalid input.Enter exactly",m,"elements.")
            return input_matrix(n, m, name)
        matrix.append(row)
    return np.array(matrix)
n = int(input("Enter number of rows: "))
m = int(input("Enter number of columns: "))
A = input_matrix(n, m, 'A')
B = input_matrix(n, m, 'B')
print("\nMatrix A:\n", A)
print("Matrix B:\n", B)
print("\nAddition of A and B:\n", A + B)
print("\nSubtraction of A and B:\n", A - B)
print("\nMultiplication of A and B (Matrix Multiplication):\n", A @ B)
print("\nTranspose of Matrix A:\n", A.T)
print("\nTranspose of Matrix B:\n", B.T)
if n == m:
    try:
        A_inv = np.linalg.inv(A)
        print("\nInverse of Matrix A:\n", A_inv)
    except np.linalg.LinAlgError:
        print("\nMatrix A is Singular and not Invertible.")

    try:
        B_inv = np.linalg.inv(B)
        print("\nInverse of Matrix B:\n", B_inv)
    except np.linalg.LinAlgError:
        print("\nMatrix B is Singular and not Invertible.")
else:
    print("\nInverse is not possible for non-square matrices.")