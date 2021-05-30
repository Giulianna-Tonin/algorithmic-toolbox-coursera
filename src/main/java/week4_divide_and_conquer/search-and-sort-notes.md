Links úteis:
https://www.cs.usfca.edu/~galles/visualization/ComparisonSort.html

#SEARCH 

LINEAR SEARCH:
- Best Case: O(1)
- Worst Case: O(n)

BINARY SEARCH:
- pŕe-requisito: estar ordenado
- Best Case: O(1)
- Worst Case: O(logn)


#SORT

*Nenhum alg sort baseado em comparação pode ser mais rápido que O(nlogn), então os que tem O(nlogn) são otimizados

INSERTION SORT
- Best Case: O(n)
- Worst Case: O(n²)


SELECTION SORT
- O(n²) (Best e Worst)
- acha o próximo menor e troca
- Fórmula de Gauss
- não depende dos dados do array e sim do seu tamanho
- na prática é um pouco menor que O(n²) pq o inner loop fica sempre menor, mas da na mesma matematicamente


MERGE SORT
- O(nlogn) (Best e Worst) - optimal
- divide and conquer
- recursivo 


QUICK SORT
- Running time depende de como estão balanceadas as metades, mas é muito eficiente na prática
- Average: O(nlogn) - ocorre se estiver balanceado 
- Worst Case: O(n²) - ocorre se não estiver balanceado
- Por isso é legal randomizar, pois escolhendo um pivot ramdomico a probabilidade de ficar balanceado é maior
- rápido pois elementos serão comparados uma ou nenhuma vez
- Se houver números iguais o tempo será O(n²), então usar o Quick Sort 3 Partition
- Quick Sort 3 Partition: Três partes - menor que pivot, igual a pivot e maior que pivot




  