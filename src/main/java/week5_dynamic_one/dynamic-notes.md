Programação dinâmica:


- Memoization 
  - Armazena resultados de subproblemas em uma tabela ou matriz chave-valor e consulta se resultado ja existe antes de computa-lo
  
- Subproblemas
  
- Analisar subproblemas para optar entre um alg iterativo ou recursivo
    
    - Iterativo:
      - resolve os subproblemas dos menores para os maiores (de baixo para cima)
      - resolve o menor subproblema e vai subindo até resolver o problema inicial
      - se todos os subproblemas precisam ser resolvidos é mais rápido pois não há a sobrecarga da recursividade. Se não há necessidade de resolver todos 
        os subproblemas para obter o resultado final não é o melhor pois nesses casos mesmo não havendo necessidade ele ira resolver todos os subproblemas
        (por exemplo knapsack com todos itens divisiveis por 100)
    
    - Recursivo: 
      - resolve os subproblemas dos maiores para os menores (de cima para baixo)
      - Começa do problema inicial e vai fazendo chamadas recursivas para os subproblemas e depois volta com os resultados 
      - pode ser mais sobrecarregado, porém é melhor para casos nos quais não é necessário resolver todos os subprolemas 
        para ter o resultado final  (por exemplo knapsack com todos itens divisiveis por 100)
      - Muito lento se não houver Memoizitaion, pois evita que ele compute novamente as chamadas que ja foram computadas 
        (consulta primeiro, se existe retorna, senão computa e salva)
    
- independencia entre as respostas dos subproblemas
  
- Problema de decisão
  
- Não pode ser ciclico

- Greedy: pegar primeiro itens com maior valor por peso (não funciona pois não garante o valor ótimo)
- Dynamic: Encontrar o valor ótimo

