    const tipoSelect = document.getElementById('tipo');
    const barcoNovoForm = document.querySelector('.barco-novo-form');

    function atualizarVisibilidade() {
        if (tipoSelect.value === 'barco novo') {
            barcoNovoForm.style.display = 'block';
            barcoNovoForm.querySelectorAll('input').forEach(i => i.required = true);
        } else {
            barcoNovoForm.style.display = 'none';
            barcoNovoForm.querySelectorAll('input').forEach(i => i.required = false);
        }
    }

    tipoSelect.addEventListener('change', atualizarVisibilidade);
    window.addEventListener('DOMContentLoaded', atualizarVisibilidade);

