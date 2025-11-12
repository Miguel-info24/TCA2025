document.addEventListener('DOMContentLoaded', () => {
      const tipo = document.getElementById('tipo');
      const novoForm = document.querySelector('.barco-novo-form');
      tipo.addEventListener('change', () => {
        novoForm.style.display = tipo.value === 'barco novo' ? 'block' : 'none';
      });
    });