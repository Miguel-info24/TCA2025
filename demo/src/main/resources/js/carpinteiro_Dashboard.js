class Pedido {
                constructor(id, nome, descricao, preco, tipo, status, barco) {
                    this.id = id;
                    this.nome = nome;
                    this.descricao = descricao;
                    this.preco = preco;
                    this.tipo = tipo;
                    this.status = status;
                    this.barco = barco;
                }
            }

            const pedidos = [
                new Pedido("001", "João Silva", "Conserto de casco", 500.0, "Conserto", "novo", "Barco Azul"),
                new Pedido("002", "Maria Santos", "Pintura do casco", 700.0, "Pintura", "novo", "Barco Vermelho"),
                new Pedido("003", "Carlos Oliveira", "Troca de vela", 300.0, "Manutenção", "novo", "Barco Verde")
            ];

            const container = document.getElementById('pedidos-container');

            pedidos.forEach(pedido => {
                const card = document.createElement('div');
                card.classList.add('pedido-card');
                card.innerHTML = `
            <h3>Pedido #${pedido.id}</h3>
            <p><strong>Cliente:</strong> ${pedido.nome}</p>
            <p><strong>Descrição:</strong> ${pedido.descricao}</p>
            <p><strong>Tipo:</strong> ${pedido.tipo}</p>
            <p><strong>Preço:</strong> R$ ${pedido.preco.toFixed(2)}</p>
            <p><strong>Status:</strong> <span class="status">${pedido.status}</span></p>
            <p><strong>Barco:</strong> ${pedido.barco}</p>
            <button class="btn-visto">Marcar como visto</button>
        `;
                container.appendChild(card);
            });

            document.querySelectorAll('.btn-visto').forEach(btn => {
                btn.addEventListener('click', () => {
                    const card = btn.closest('.pedido-card');
                    card.classList.add('visto');
                    const statusSpan = card.querySelector('.status');
                    statusSpan.textContent = 'visto';
                    btn.disabled = true;
                    btn.textContent = 'Visto';
                });
            });