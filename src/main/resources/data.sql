INSERT INTO usuario (nome, papel) VALUES ('João da Silva', 'CLIENTE');
INSERT INTO usuario (nome, papel) VALUES ('Maria Oliveira', 'CLIENTE');
INSERT INTO usuario (nome, papel) VALUES ('Pedro Santos', 'CLIENTE');
INSERT INTO usuario (nome, papel) VALUES ('Ana Costa', 'CLIENTE');
INSERT INTO usuario (nome, papel) VALUES ('Carlos Rodrigues', 'CLIENTE');
INSERT INTO usuario (nome, papel) VALUES ('Letícia Ribeiro', 'GESTOR');
INSERT INTO usuario (nome, papel) VALUES ('Cecília Pereira', 'GESTOR');
INSERT INTO usuario (nome, papel) VALUES ('Thiago Gomes', 'GESTOR');
INSERT INTO usuario (nome, papel) VALUES ('Arthur Novaes', 'GESTOR');
INSERT INTO usuario (nome, papel) VALUES ('Mariana Farias', 'GESTOR');

INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (66000000.0, 'Contrato de arrendamento de terreno de 50000 km² para instalação de uma nova fazenda eólica, com o objetivo de ampliar a capacidade de produção de energia limpa da empresa em uma região estratégica.', '2024-06-10 10:00:00', '2024-06-11 12:30:00', 3, 6);
INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (45000000.0, 'Contrato referente à aquisição de uma nova área de 150000km² para o desenvolvimento de um parque eólico.', '2024-06-14 14:30:00', '2024-06-15 15:30:00', 1, 9);
INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (31500000.0, 'Contrato para a expansão de parque eólico em área de 100000 km² para instalação de novas turbinas eólicas, visando aumentar a capacidade de geração de energia renovável da empresa.', '2024-06-15 15:06:00', '2024-06-15 15:06:00', 4, 7);
INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (17300421.0, 'Contrato para construção, operação e manutenção de parque eólico entre Queventu Ltda. e Barreiras-BA, incluindo instalação de turbinas, conexão à rede elétrica e operação por 20 anos.', '2024-06-15 15:06:00', '2024-06-15 15:06:00', 2, 9);
INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (150000000.0, 'Acordo entre Queventu Ltda. e Ilhéus, para instalação e operação de parque eólico, com compromisso de geração sustentável de energia e integração harmoniosa ao ecossistema local.', '2024-06-15 15:06:00', '2024-06-15 15:06:00', 2, 8);
INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (84300000.0, 'Contrato para o desenvolvimento de um projeto eólico, abrangendo a instalação de turbinas, integração à rede elétrica local e operação contínua por 15 anos.', '2024-06-15 15:06:00', '2024-06-15 15:06:00', 4, 10);
INSERT INTO contrato (valor, descricao, data_criacao, data_ultima_alteracao, contratado_id, contratante_id) VALUES (700000.0, 'Contrato de parceria para a construção e gestão de um parque eólico, com foco na eficiência operacional, segurança ambiental e benefícios econômicos para a região.', '2024-06-15 15:06:00', '2024-06-15 15:06:00', 5, 8);

INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (1, 'uploads\doc01.pdf', 'doc01.pdf');
INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (2, 'uploads\doc02.pdf', 'doc02.pdf');
INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (3, 'uploads\doc03.pdf', 'doc03.pdf');
INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (4, 'uploads\doc04.pdf', 'doc04.pdf');
INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (5, 'uploads\doc05.pdf', 'doc05.pdf');
INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (6, 'uploads\doc06.pdf', 'doc06.pdf');
INSERT INTO documento (contrato_id, caminho_arquivo, nome_arquivo) VALUES (7, 'uploads\doc07.pdf', 'doc07.pdf');