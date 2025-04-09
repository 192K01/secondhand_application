networks = {'hsa', 'mm', 'dme', 'cel', 'sce'};
n = length(networks);

% results 폴더 없으면 생성
if ~exist('results', 'dir')
    mkdir('results');
end

for i = 1:n
    for j = i+1:n
        nameA = networks{i};
        nameB = networks{j};

        fprintf("🔄 Exporting match for %s vs %s...\n", nameA, nameB);

        % 매칭 결과 불러오기
        match_file = fullfile('results', sprintf('matching_%s_%s.mat', nameA, nameB));
        if ~isfile(match_file)
            warning('⚠️  결과 파일 없음: %s', match_file);
            continue;
        end
        load(match_file);  % M

        % 단백질 ID 로딩
        dataA = load(fullfile('data', [nameA '.mat'])); nodesA = dataA.nodes;
        dataB = load(fullfile('data', [nameB '.mat'])); nodesB = dataB.nodes;

        [row, col] = find(M);
        
        % 파일 저장 (results 폴더 안에)
        output_file = fullfile('results', sprintf('matches_%s_%s.txt', nameA, nameB));
        fid = fopen(output_file, 'w');
        for k = 1:length(row)
            fprintf(fid, '%s\t%s\n', nodesB{row(k)}, nodesA{col(k)});
        end
        fclose(fid);

        fprintf("✅ 저장 완료: %s\n", output_file);
    end
end
