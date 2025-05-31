package dev.anzame.myblog.repository;

import dev.anzame.myblog.model.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class PostRepositoryTest {

    @Autowired
    private PostRepository postRepository;

    @Test
    void 投稿を保存して一覧で取り出せる() {
        // 準備
        Post post = new Post();
        post.setTitle("テスト投稿");
        post.setContent("これはテスト本文です。");

        // 実行
        postRepository.save(post);

        // 検証
        List<Post> posts = postRepository.findAll();
        assertThat(posts).hasSize(1);
        assertThat(posts.get(0).getTitle()).isEqualTo("テスト投稿");
    }
}
