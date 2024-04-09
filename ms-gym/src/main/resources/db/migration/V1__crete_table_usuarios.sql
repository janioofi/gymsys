CREATE TABLE usuario
(
    id_usuario BIGINT GENERATED BY DEFAULT AS IDENTITY NOT NULL,
    usuario    VARCHAR(255)                            NOT NULL,
    senha      VARCHAR(255)                            NOT NULL,
    perfil     VARCHAR(255),
    CONSTRAINT pk_usuarios PRIMARY KEY (id_usuario)
);

ALTER TABLE usuario
    ADD CONSTRAINT uc_usuarios_usuario UNIQUE (usuario);