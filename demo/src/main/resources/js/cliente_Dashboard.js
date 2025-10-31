        class Pedido {
            constructor(id, descricao, preco, tipo, status, dataInicio, dataFim, barco) {
                this.id = id;
                this.descricao = descricao;
                this.preco = preco;
                this.tipo = tipo;
                this.status = status;
                this.dataInicio = dataInicio;
                this.dataFim = dataFim;
                this.barco = barco;
            }
        }

        const pedidoDoCliente = new Pedido(
            "001",
            "Pintura do casco",
            700.0,
            "Pintura",
            "Finalizado",
            "02/09/2025",
            "04/09/2025",
            "Barco Vermelho"
        );

        const container = document.getElementById('pedidos-container');

        const card = document.createElement('div');
        card.classList.add('pedido-card');
        card.innerHTML = `
            <h3>Pedido #${pedidoDoCliente.id}</h3>
            <p><strong>Descrição:</strong> ${pedidoDoCliente.descricao}</p>
            <p><strong>Tipo:</strong> ${pedidoDoCliente.tipo}</p>
            <p><strong>Preço:</strong> R$ ${pedidoDoCliente.preco.toFixed(2)}</p>
            <p><strong>Status:</strong> <span class="status">${pedidoDoCliente.status}</span></p>
            <p><strong>Período:</strong> ${pedidoDoCliente.dataInicio} até ${pedidoDoCliente.dataFim}</p>
            <p><strong>Barco:</strong> ${pedidoDoCliente.barco}</p>
        `;
        container.appendChild(card);