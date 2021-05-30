SOMA
A soma de Fn será Fn+2 - 1
Ex.:

1  2  3  4  5  6  7    8    9  10     Index
1  2  4  7  12 20                     soma
1  1  2  3  5  8  13   21   34  55    Fib

F3 = F5 - 1 = 5-1 =4
F4 = F6 - 1 = 8-1 = 7
F5 = F7 - 1 =  13-1 = 12

Só impares: F1 + F3 + F5 + F7 + … + F2n-1 = F2n
Só pares: F2 + F4 + F6 + F8 +.... + F2n = F2n+1 –1
Soma dos quadrados:F1²+ F2² + F3² + F4² + F5² +... + Fn² = Fn Fn+1




ULTIMOS DIGITOS
último digito = mod 10 = %10
último digito de Fn será a soma dos ultimos digiltos dos ultimos dois numeros:
lastDigN = lastDig(n-1) + lastDig(n-2)  
F[i] = (F[i-1]) + F[i-2]) % 10

de 60 em 60 o ultimo digito é igual
Ex.: F14 = 377 e F74 é 1.304.969.544.928.657, também terminado em 7
Últimos dois dígitos: de 300 em 300
Últimos três dígitos: 1.500 em 1.500.





PISANO PERIOD - MOD
A Pisano Period starts with 0 1

You compute the pisano period by generating the fibonnaci integers % m.
As you generate this seq, you test for the patter 0, 1.
If you find it now you know that your pisano period is the number
of integers you generated before the 0, 1 sequence appeared.

      0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, 233, 377, 610
mod2  0  1  1  0  1  0  0  1   1   0   1   1   0    1    1    0     = ciclo de 3
mod3  0  1  1  2  0  2  2  1   0   1   1   2   0    2    2    1     = ciclo de 8





HUGEVALUES
Recursos acima e Big integer para somas onde pisano period não resolve :/



lINKS
https://www.cs.usfca.edu/~galles/visualization/DPFib.html
